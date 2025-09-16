This is app present how to secure api using tls. 

 some commands use to generate certificate

TLS (Transport Layer Security) – Basics
1️⃣ What is TLS?

TLS = successor of SSL (more secure).

It provides:

Encryption → data is unreadable to attackers.

Integrity → data can’t be tampered with.

Authentication → server (and sometimes client) identity is verified.

👉 Without TLS, your passwords, tokens, API keys travel in plain text (bad for security).

2️⃣ How TLS Works (High Level)

TLS uses Public Key Cryptography:

Server has a private key (kept secret).

Server certificate (signed by CA) contains the public key.

When a client (browser, API consumer) connects:

Handshake starts → client asks server for certificate.

Client verifies if certificate is trusted (via Certificate Authority, CA).

A shared session key is generated → used for fast symmetric encryption.

From then on → all communication is encrypted.

3️⃣ TLS Key Concepts You Need to Know

Certificate → digital identity of server, signed by CA.

CA (Certificate Authority) → trusted third party (e.g., Let’s Encrypt, DigiCert).

Keystore → file that stores private keys + certificates (server side).

Truststore → file that stores trusted CA/public certs (client side).

Self-signed certificate → you generate it yourself (for learning/testing).

Chain of trust → root CA → intermediate CA → server certificate.

4️⃣ TLS in Spring Boot Context

Spring Boot uses embedded Tomcat (or Jetty/Undertow).

By default, apps run on HTTP (port 8080).

To enable HTTPS (TLS):

You need a keystore (server certificate).

Configure it in application.yml or application.properties.

Server will then run on HTTPS (port 8443 by convention).

5️⃣ Practical Flow (Learning Roadmap for TLS)

Here’s how we’ll learn TLS in hands-on steps:

Generate a self-signed certificate using keytool.

Configure Spring Boot to use that certificate → run app on HTTPS (port 8443).

Test with browser and curl (https://localhost:8443).

(Optional) Add real CA-signed cert (Let’s Encrypt) → for production.

CMD>
    keytool -genkeypair -alias springboot -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore keystore.p12 -validity 3650
    private key > changeit
