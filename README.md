# openfin-solace-sample
A sample web app that demonstrates multi-protocol\multi-language support over Solace.

## Setting up a PubSub+ Software broker locally
Download the Solace PubSub+ Standard Docker Container - https://products.solace.com/download/PUBSUB_DOCKER_STAND

Run the following commands (replace x.x.x.x with the Solace PubSub+ Broker version)

```
 >docker load -i .\solace-pubsub-standard-x.x.x.x-docker.tar.gz
 >docker run -d -p 80:80 -p 8080:8080 -p 55555:55555 --shm-size=2g --env username_admin_global
 accesslevel=admin --env username_admin_password=admin  --name=solace solace-pubsub-standard:x.x.x.x
```

To setup your local Solace broker with secure websockets so you can use it with OpenFin, use the following steps:

1. Get the Container ID of the started Solace Pubsub+ Broker by running ```docker ps``` and getting the appropriate container id
2. Generate a PEM certificate file using OpenSSL (for example using [this link](https://rietta.com/blog/2012/01/27/openssl-generating-rsa-key-from-command/) or use your own certifcate file
3. Use the following command to copy your public key cert to the Solace PubSub+ Container (this assumes your certificate file is called OpenFin.pem and the Container ID is 2e16eaf93225 
```docker cp OpenFin.pem 2e16eaf93225:/usr/sw/jail/certs```
1. To enable the certificate with the Solace PubSub+ broker, run the following commands:
  
```
>docker exec -it 2e16eaf93225  cli
>enable
>configure
>ssl-server-certificate OpenFin.pem
```

### ... or sign up for a free Solace Cloud account
Sign up for a free [Solace Cloud](http://cloud.solace.com) account with all the endpoints enabled. You will have to change the connectivity details in the sample app to match the endpoints in your Solace Cloud instance.

## Setting up the app

The app consists of three parts -

### Running the javascript subscriber
To start this, navigate to the web-app direcory and run 
```
    npm install
    npm start
```

Navigate to http://localhost:3000 in your browser


### Running the python publisher
Navigate to the python-publisher folder and run the following commands

```
    python mqtt-publish.py
```

### Running the java publisher
Navigate to the java-publisher folder and run the following commands (assuming you have maven installed)

```
    mvn install:install
    mvn exec:java
```
