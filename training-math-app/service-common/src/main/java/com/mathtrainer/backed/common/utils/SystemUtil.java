package com.mathtrainer.backed.common.utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Optional;

public class SystemUtil {

    public static Optional<Integer> findFreePort(String configPortRange) {
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
                System.out.println(String.format("****** port %s is used ******", port));
            }
        }
        return freePort;
    }
}
