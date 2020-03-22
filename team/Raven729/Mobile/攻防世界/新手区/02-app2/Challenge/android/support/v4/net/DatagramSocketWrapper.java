package android.support.v4.net;

import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;

class DatagramSocketWrapper extends Socket {
    class DatagramSocketImplWrapper extends SocketImpl {
        public DatagramSocketImplWrapper(DatagramSocket arg2, FileDescriptor arg3) {
            super();
            this.localport = arg2.getLocalPort();
            this.fd = arg3;
        }

        protected void accept(SocketImpl arg2) {
            throw new UnsupportedOperationException();
        }

        protected int available() {
            throw new UnsupportedOperationException();
        }

        protected void bind(InetAddress arg2, int arg3) {
            throw new UnsupportedOperationException();
        }

        protected void close() {
            throw new UnsupportedOperationException();
        }

        protected void connect(String arg2, int arg3) {
            throw new UnsupportedOperationException();
        }

        protected void connect(InetAddress arg2, int arg3) {
            throw new UnsupportedOperationException();
        }

        protected void connect(SocketAddress arg2, int arg3) {
            throw new UnsupportedOperationException();
        }

        protected void create(boolean arg2) {
            throw new UnsupportedOperationException();
        }

        protected InputStream getInputStream() {
            throw new UnsupportedOperationException();
        }

        public Object getOption(int arg2) {
            throw new UnsupportedOperationException();
        }

        protected OutputStream getOutputStream() {
            throw new UnsupportedOperationException();
        }

        protected void listen(int arg2) {
            throw new UnsupportedOperationException();
        }

        protected void sendUrgentData(int arg2) {
            throw new UnsupportedOperationException();
        }

        public void setOption(int arg2, Object arg3) {
            throw new UnsupportedOperationException();
        }
    }

    public DatagramSocketWrapper(DatagramSocket arg2, FileDescriptor arg3) {
        super(new DatagramSocketImplWrapper(arg2, arg3));
    }
}

