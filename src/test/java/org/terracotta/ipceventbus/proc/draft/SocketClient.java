/*
 * Copyright 2015 Terracotta, Inc., a Software AG company.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terracotta.ipceventbus.proc.draft;

import javax.net.SocketFactory;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author Mathieu Carbou
 */
public class SocketClient {
  public static void main(String... args) throws Exception {
    Socket socket = SocketFactory.getDefault().createSocket();
    socket.connect(new InetSocketAddress("localhost", Integer.parseInt(args[0])));
    new ObjectOutputStream(socket.getOutputStream()).writeObject("hello world!");
    System.out.println("client read from server: " + new ObjectInputStream(socket.getInputStream()).readObject());
    socket.close();
  }
}
