package io.github.daihaowxg;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Optional;

@SpringBootApplication
public class PlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(Environment environment) {
        return args -> {
            String appName = environment.getProperty("spring.application.name") != null
                    ? environment.getProperty("spring.application.name")
                    : "";
            String port = environment.getProperty("server.port") != null ? environment.getProperty("server.port")
                    : "8080";
            String path = environment.getProperty("server.servlet.context-path") != null
                    ? environment.getProperty("server.servlet.context-path")
                    : "";
            String ip = getHostIp();
            System.out.println(
                    "\n\n\t" +
                            "----------------------------------------------------------\n\t" +
                            "Application " + appName + " is running! Access URLs:\n\t" +
                            "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                            "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                            "Document: \thttp://" + ip + ":" + port + path + "/swagger-ui.html\n\t" +
                            "------------------------------------------------------------" + "\n");
        };
    }

    /**
     * 获取本机真实 IP 地址（非回环地址）
     * 优先返回物理网卡的 IPv4 地址，跳过 VPN 和虚拟隧道接口
     */
    private static String getHostIp() {
        try {
            // 优先查找物理网卡的 IP
            Optional<String> physicalIp = Collections.list(NetworkInterface.getNetworkInterfaces())
                    .stream()
                    .filter(ni -> {
                        try {
                            String name = ni.getName();
                            // 只保留物理网卡接口
                            return !ni.isLoopback() && !ni.isVirtual() && ni.isUp()
                                    && !name.startsWith("utun") && !name.startsWith("tun")
                                    && !name.startsWith("tap") && !name.startsWith("ppp")
                                    && (name.startsWith("en") || name.startsWith("eth") || name.startsWith("wlan"));
                        } catch (SocketException e) {
                            return false;
                        }
                    })
                    .flatMap(ni -> Collections.list(ni.getInetAddresses()).stream())
                    .filter(addr -> !addr.isLoopbackAddress() && addr.getHostAddress().indexOf(':') == -1)
                    .map(InetAddress::getHostAddress)
                    .findFirst();

            if (physicalIp.isPresent()) {
                return physicalIp.get();
            }

            // 备用方案：查找任何非回环、非虚拟隧道的 IPv4 地址
            return Collections.list(NetworkInterface.getNetworkInterfaces())
                    .stream()
                    .filter(ni -> {
                        try {
                            String name = ni.getName();
                            return !ni.isLoopback() && !ni.isVirtual() && ni.isUp()
                                    && !name.startsWith("utun") && !name.startsWith("tun")
                                    && !name.startsWith("tap") && !name.startsWith("ppp");
                        } catch (SocketException e) {
                            return false;
                        }
                    })
                    .flatMap(ni -> Collections.list(ni.getInetAddresses()).stream())
                    .filter(addr -> !addr.isLoopbackAddress() && addr.getHostAddress().indexOf(':') == -1)
                    .map(InetAddress::getHostAddress)
                    .findFirst()
                    .orElse("127.0.0.1");
        } catch (SocketException e) {
            e.printStackTrace();
            return "127.0.0.1";
        }
    }
}
