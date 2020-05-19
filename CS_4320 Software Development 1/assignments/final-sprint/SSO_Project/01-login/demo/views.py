from django.shortcuts import render
import json
from django.contrib.auth.decorators import login_required
from django.contrib.auth import logout as django_logout
from django.http import HttpResponseRedirect

# Create your views here.

def index(request):

	products = [
		{'title': 'PlayStation', 'price': 300, 'image': 'https://cdn.auth0.com/blog/django-webapp/playstation.png'},
		{'title': 'iPhone', 'price': 900, 'image': 'https://cdn.auth0.com/blog/django-webapp/iphone.png'},
		{'title': 'Yummy Pizza', 'price': 10, 'image': 'https://cdn.auth0.com/blog/django-webapp/pizza.png'},
	]

	context = {
		'products': products,
	}

	return render(request, 'demo/index.html', context)

@login_required
def profile(request):
    user = request.user
    auth0user = user.social_auth.get(provider='auth0')
    userdata = {
        'user_id': auth0user.uid,
        'name': user.first_name,
        'picture': auth0user.extra_data['picture']
    }

    return render(request, 'demo/profile.html', {
        'auth0User': auth0user,
        'userdata': json.dumps(userdata, indent=4)
    })


def logout(request):
    log_out(request)
    return_to = 'http://localhost:3000/demo'
    logout_url = 'https://%s/v2/logout?client_id=%s&%s' % \
                 (settings.SOCIAL_AUTH_AUTH0_DOMAIN, settings.SOCIAL_AUTH_AUTH0_KEY, return_to)
    return HttpResponseRedirect(logout_url)

"""
def logout(request):
    django_logout(request)
    domain = 'dev-to4lrgfq.auth0.com'
    client_id = '90H2szQy6MZ82jnGXIe8Pw6KwUD5jxhl'
    return_to = 'http://localhost:3000/demo'
    return HttpResponseRedirect(f'https://{domain}/v2/logout?returnTo={return_to}&client_id={client_id}')
    """