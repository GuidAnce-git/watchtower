package com.mine.connectivityAnalyzer;

import io.quarkus.scheduler.Scheduled;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import static io.quarkus.scheduler.Scheduled.ConcurrentExecution.SKIP;

@ApplicationScoped
public class ConnectivityAnalyzer {

    @ConfigProperty(name = "fritzBox.hostname")
    String hostname;

    @Scheduled(every="1s", concurrentExecution = SKIP)
    public void sendPingRequest() {
        pingRequest(hostname);
    }

    // Sends ping request to a provided IP address
    private void pingRequest(String ipAddress)
    {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName(ipAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println("Sending Ping Request to " + ipAddress);
        try {
            if (inetAddress != null) {
                if (inetAddress.isReachable(5000))
                    System.out.println("Host is reachable");
                else
                    System.out.println("Sorry! We can't reach to this host");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
