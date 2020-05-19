# How to set up and run Django SSO project

## To run this program create a file called 'requirements.txt' and add the following:  

django~=2.1
social-auth-app-django~=3.1
python-jose~=3.0
python-dotenv~=0.9


## Next

in terminal run:

pip install -r requirements.txt
pip install --upgrade django-crispy-forms


## Once that is done:

In terminal navigate to just inside the 01-login foler within the SSO_Project folder.  

You should see a file called manage.py 

enter the command: 

python3 manage.py runserver 3000

## Note: If it doesn't run  

You may have to set up the servers on your machine  

run:

python3 manage.py migrate 

### if that doesn't work try:

python3 manage.py makemigrations

### and then:

python3 manage.py migrate

##then try:  

python3 manage.py runserver 3000


## If it is running, then open http://localhost:3000 in your browser

You should be greeted with the Blog application that will have a navbar to take you to the store, about page, or login. You will not be able to make a new post unless logged in. When you click login it will take you to the SSO login page

I used 'test@test.com' and 'Testing321' as the username and password for testing everything. Once logged in it will redirect you to the store automatically. The is the part I was having some trouble with. On login no matter the app, you will go to the store and on logout you will go to the blog. 

The links in the navbars now work properly from before and will not produce errors. They are set up in the code that even
if you were to change the address name of a link it will still redirect you to the right place without changing it in all of the different files of the project, with the exception of login as it only goes to the Auth0 server. 

I was in the middle of redo-ing the user profiles on the blog so I don't have that implemented. 

http://localhost:3000/demo will take you to the 2nd app. If you had previously logged in, you will see the option in the menu bar to view the profile and a logout button. If logged in you can view the profile. If you go to http://localhost:3000/demo without being logged in, you will see the page but no Profile link and the option to login, it will take you to the same Auth0 login server. 

These are 2 different apps not just pages on the same website, so when you login to one and navigate to the other, it is checking your SSO token with the Auth0 server. 

You can create a user, login with Google, or use the test on I created. You will see the test blog posts I made.
