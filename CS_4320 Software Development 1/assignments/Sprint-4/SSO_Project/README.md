## How to set up and run Django SSO project

### To run this program create a file called 'requirements.txt' and add the following:  

django~=2.1
social-auth-app-django~=3.1
python-jose~=3.0
python-dotenv~=0.9

### Next

in terminal run:

pip install -r requirements.txt

### Once that is done:

In terminal navigate to just inside the 01-login foler within the SSO_Project folder.  

You should see a file called manage.py 

enter the command: 

python3 manage.py runserver 3000

### Note: If it doesn't run  

You may have to set up the servers on your machine  

run:

python3 manage.py migrate 

and then try:  

python3 manage.py runserver 3000


### If it is running, then open http://localhost:3000 in your browser

You should be greeted with an Auth0 page to click the login button, which will redirect you to the SSO login server.
To test this you can try to go directly to the dashboard without loggin in...

http://localhost:3000/dashboard  which will redirect you to the login page. 

Once you login you will see the dashboard with the login info. 

I didn't have too much time to play around and troubleshoot but I have a 2nd app that uses the same login credentials for the Auth0 SSO. 

http://localhost:3000/demo will take you to the 2nd app. If you had previously logged in, you will see the option in the menu bar to view the profile and a logout button. If logged in you can view the profile.

If you go to http://localhost:3000/demo without being logged in, you will see the page but no Profile link and the option to login, it will take you to the same Auth0 login server. 

I don't have the redirects working perfectly, so you always go back to the main dashboard page when logged in. The Home link on the demo page takes you to the main login page instead of demo home. The profile button, if clicked more than once will keep adding paths and throw a debug error.
