# Encryptex-ClientSide

<p align="center">
  <img src="https://github.com/SAED2906/Encryptex-ClientSide/blob/main/Process.PNG" width="1500" alt="accessibility text">
</p>

Encryptex is a Java program designed to create a platform for end-to-end encrypted file transfers between registered users of the program, users can register and login to a server version of the project that handles all the requests on a different computer.

This is the client-side version of the project.

When a user attempts to login the program sends the user info to a database server on an external computer. This external computer then tells the program whether the client has the correct authority, if the client has the correct authority, the program gives them the option to select whether to send or receive files, if the client wishes to send files, then the program will require a file and a client destination. When both are confirmed the client’s document will be encrypted with a shared hash key. This hash key is created by combining the username, PROCESSOR_IDENTIFIER and the PROCESSOR_LEVEL to create a hash key, this hash key is unique per client, when a connection has been established the client and destination client’s hash keys are combined to encrypt the file with their shared key.

The encrypted file then gets transferred to the client where it is decrypted and stored.
The shared hash key will be stored on each computer within the transfer for future use as well as a PCID to help distinguish different computers.

<p align="center">
  <img src="https://github.com/SAED2906/Encryptex-ClientSide/blob/main/GUIDemo.png" width="450" alt="accessibility text">
</p>

ServerSide: https://github.com/SAED2906/Encryptex-ServerSide

BOTH THE CLIENT AND SERVER ARE CURRENTLY LISTENING TO LOCALHOST
to you with a different IP, download the code and replace all intances of InetAddress.getLocalHost().getHostAddress(); with your own local IP, or with your public IP, given you have port fowarded 25565 and 25575 to your static IP.
