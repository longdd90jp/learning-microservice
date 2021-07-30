package com.mathtrainer.backed.auth.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Optional;

@Slf4j
public class SystemUtil {

    public static Optional<Integer> findFreePort() {
        String configPortRange = System.getProperty("port.range");
        if(StringUtils.isEmpty(configPortRange)) {
            log.error("****** system variable PORT_RANGE is empty ******");
            return Optional.empty();
        }

        String[] portRanges = configPortRange.split("_");
        Optional<Integer> freePort = Optional.empty();
        int startPort = Integer.valueOf(portRanges[0]);
        int endPort = Integer.valueOf(portRanges[1]);;

        for (int port = startPort;  port <= endPort; port++) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                if(serverSocket != null && serverSocket.getLocalPort() == port) {
                    freePort = Optional.of(port);
                    break;
                }
            } catch (IOException e) {
                log.info(String.format("****** port %s is used ******", port));
            }
        }
        return freePort;
    }
}
