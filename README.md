# openfin-solace-sample
A sample web app that demonstrates multi-protocol\multi-language support over Solace

## Setting up a PubSub+ Software broker
Download the Solace PubSub+ Standard Docker Container - https://products.solace.com/download/PUBSUB_DOCKER_STAND

Run the following commands (replace x.x.x.x with the Solace PubSub+ Broker version)

```
 >docker load -i .\solace-pubsub-standard-x.x.x.x-docker.tar.gz
 >docker run -d -p 80:80 -p 8080:8080 -p 55555:55555 --shm-size=2g --env username_admin_global
 accesslevel=admin --env username_admin_password=admin  --name=solace solace-pubsub-standard:x.x.x.x
```

## Setting up the app

The app consists of three parts -

### Running the javascript Subscriber
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
    mvn run:exec
```
