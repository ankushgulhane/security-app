Step 1: Learn the concepts

Keystore = server’s private key + cert

Truststore = list of certs your app trusts

In mTLS:

Server has a keystore (its identity)

Server has a truststore (which clients it trusts)

Client has a keystore (its identity)

Client has a truststore (which servers it trusts)

Step 2: Generate certificates

One for server

One for client

Share their public certificates into each other’s truststore

Step 3: Configure Spring Boot server

Require client certificates (server.ssl.client-auth=need)

Point to server keystore & truststore

Step 4: Configure a test client

Could be:

Another Spring Boot app

Or curl with client cert (curl --cert client.crt --key client.key https://...)

Step 5: Run & test

Without cert → access denied 🚫

With valid cert → success ✅



 commands

Step 1: Generate Server Keystore

>keytool -genkeypair -alias server -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore server-keystore.p12 -validity 3650



Export Server Certificate

> keytool -export -alias server -keystore server-keystore.p12 -rfc -file server-cert.pem

Step 3: Generate Client Keystore

> keytool -genkeypair -alias client -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore client-keystore.p12 -validity 3650

Step 4: Export Client Certificate
> keytool -export -alias client -keystore client-keystore.p12 -rfc -file client-cert.pem


Step 5: Create Server Truststore (trust client)

> keytool -import -alias client -file client-cert.pem -keystore server-truststore.p12 -storetype PKCS12

Step 6: Create Client Truststore (trust server)

>keytool -import -alias server -file server-cert.pem -keystore client-truststore.p12 -storetype PKCS12


TEST APP using curl
> curl -vk https://localhost:8443/mtls/hi --cert client-keystore.p12:client --cert-type P12