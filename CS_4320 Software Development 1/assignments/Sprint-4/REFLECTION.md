<<<<<<< HEAD
# Reflections of SSO Project

## Which Projects?
=======
## Reflections of SSO Project

### Which Projects?
>>>>>>> 99d9e4ede46cc3a479e06960eeb7367b5263a72b
I looked at a variety of SSO implementations for various different frameworks even. The starting point was the  
two github repositories for Sails.js and Ory Hydra. I feel sorry for those in the class that haven't taken a web  
development course, because Ory Hydra seemed extremely complicated to me and I've taken web development and have  
played around with other frameworks a bit. 

I knew I wanted to implement something using the Django framework so I erroniously started looking there instead  
of looking through the OAuth and OpenID Connect. I found various open source solutions and went pretty far into 
trying PyPI's implementation for SSO using Django. Once that effort stalled significantly I looked into Passportjs.  
I got that working completely but it didn't meet the requirements for SSO. Some of the solutions I found to convert  
it to SSO or add that layer to it, weren't cutting it. 

I then found Auth0's website and man oh man. Perfect tutorials and explainations. Plus it supports a TON of  
frameworks. Was hands down the best of the bunch that I looked at. 

## Why I chose Auth0?
Many reasons, first it supported the framework that I wanted to use and provided tutorials for that framework as  
well as the tutorial to set up and connect a page to the auth server. This is where I found a decent amount of stress  
in the other implementations. 

(The concept is really simple, you set up tokens for the client and server and the server  
will log in someone from 1 of a group of apps that uses that server and once logged in, if you navigate to any other  
app that uses that same server, then it will check your token and have you automatically logged in to that app.)

However, a lot of the solutions that I messed around with confused me with setting up the server itself, and getting  
the authentications working. 

Auth0's tutorials were amazing, it will literally walk you through setting up the auth server on your framework of  
choice. I have already messed around with Django some out of curiosity and found that they support that framework  
really well. The documentation and explainations are very clear and easy to grasp as they aren't overly technical

## How far I got?
I would say 90%. I got the authentication working to automatically have you logged in for separate apps, but the
callback URLs aren't completely correct. Say you start with App 1 and login, then you will go to App 1's dashboard 
after being logged in. Say you start with App 2 and login you will still be taken to App 1's dashboard, but the login
for App 2 is valid.  

I'm still new to Django and some of the links are a little wonky. I've got it to a point that you could completely  
change the apps content displays themselves to create a truly original SSO group.

## What obstacles I encountered?
1. Complexity

There are so many frameworks to choose from and so many different attempted solutions, that it was a little daunting
to try and tackle. Some were very technical in their setup and documentation and when you are trying to get a new
concept, it is just a little much.

2. Setting up a server

I hate even typing that. I've had the database course and a web development course, but for some reason, I keep getting
hung up on just starting the server portion to handle the token authentication. Setting up a server to run other web
frameworks through just keeps escaping me without tons of research and tutorials.

3. Unfamiliar territory

Django is still pretty new to me, but a little more intuitive than some other frameworks that I've seen. As with
anything you are new to, there is a learning curve. I kept getting mixed up at times with all of the different paths
and linking that needed to be done between the apps as I was going through the app file tree.

