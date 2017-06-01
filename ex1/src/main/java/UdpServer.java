import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h2>Task 1</h2>
 * <p>
 *     Your first task is to write an UDP server instead of a TCP server. UDP splits your data into small data fragments
 *     and sends them off without any guarantee of order: you don't know which package comes first! (A bit like
 *     concurrency). Instead of the constantly open output- and input-streams from the TCP server, you receive and
 *     send things from/to byte arrays.
 * </p>
 * <p>
 *     So, each package receives a certain amount of bytes. In our (kinda artificial) case we only receive 10 bytes.
 *     Use the {@link #DATA_BUFFER} for storing and retrieving data in this exercise.
 * </p>
 * <p>
 *     Your job is to implement a UDP server that binds to a socket on your local machine and waits until a client
 *     sends some data. When the data arrives you print it out. That's it! When it's printed, notice how much data is
 *     sent (and how much isn't). That's the drawback of this approach. On the other hand it's fast!
 * </p>
 */
public class UdpServer implements Runnable {

    private static final byte[] DATA_BUFFER = new byte[10];

    @Override
    public void run() {
        // 1. Create a UDP server that binds (listens) to a port
        InetSocketAddress inet = new InetSocketAddress("localhost", 12355);
        try {
            DatagramSocket socket = new DatagramSocket(inet);
            // 2. Wait for some data to arrive
            DatagramPacket packet = new DatagramPacket(DATA_BUFFER, 10);
            socket.receive(packet);
            // 3. Print the data!
            System.out.println(Arrays.toString(DATA_BUFFER));
            socket.disconnect();
            socket.close();
        } catch (SocketException ex) {
            Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException {
        // Run the udp server in a thread here
        Thread t = new Thread(new UdpServer());
        t.start();
        // Wait for the thread to finish before the program stops
        while (t.isAlive()) { }
    }

}
