from django.shortcuts import render, get_object_or_404
from .models import Post
from django.contrib.auth.mixins import LoginRequiredMixin, UserPassesTestMixin
from django.contrib.auth.models import User
from django.views.generic import (ListView, DetailView, 
	CreateView, UpdateView, DeleteView)
#from django.http import HttpResponse

# function-based views
def home(request):
	context = {
		'posts': Post.objects.all()
	}
	return render(request, 'blog/home.html', context)
	#HttpResponse('<h1>Blog Home</h1>')		** render returns HttpResponse in the background

# class-based view
# for the url it will look for template w/ naming convention:
# <app>/<model>_<viewtype>.html  or change it manually
class PostListView(ListView):
	model = Post
	template_name = 'blog/home.html'
	context_object_name = 'posts'
	ordering = ['-date_posted']	# will reorder blog posts for newest at top
	paginate_by = 5

class UserPostListView(ListView):
	model = Post
	template_name = 'blog/user_posts.html'
	context_object_name = 'posts'
	paginate_by = 5

	def get_queryset(self):
		user = get_object_or_404(User, username=self.kwargs.get('username'))
		return Post.objects.filter(author=user).order_by('-date_posted')

class PostDetailView(DetailView):
	model = Post

class PostCreateView(LoginRequiredMixin, CreateView):
	model = Post
	fields = ['title', 'content']
	# success_url = '/'			using absoulute path url w/ reverse

	def form_valid(self, form):
		form.instance.author = self.request.user
		return super().form_valid(form)

class PostUpdateView(LoginRequiredMixin, UserPassesTestMixin, UpdateView):
	model = Post
	fields = ['title', 'content']

	def form_valid(self, form):
		form.instance.author = self.request.user
		return super().form_valid(form)

	def test_func(self):
		post = self.get_object()

		if self.request.user == post.author:
			return True
		return False

class PostDeleteView(LoginRequiredMixin, UserPassesTestMixin, DeleteView):
	model = Post
	success_url = '/'

	def test_func(self):
		post = self.get_object()

		if self.request.user == post.author:
			return True
		return False

def about(request):
	#return HttpResponse('<h1>Blog About</h1>')
	return render(request, 'blog/about.html', {'title': 'About'})

def logout(request):
    log_out(request)
    return_to = 'http://localhost:3000'
    logout_url = 'https://%s/v2/logout?client_id=%s&%s' % \
                 (settings.SOCIAL_AUTH_AUTH0_DOMAIN, settings.SOCIAL_AUTH_AUTH0_KEY, return_to)
    return HttpResponseRedirect(logout_url)

"""
def logout(request):
    django_logout(request)
    domain = 'dev-to4lrgfq.auth0.com'
    client_id = '90H2szQy6MZ82jnGXIe8Pw6KwUD5jxhl'
    return_to = 'http://localhost:3000/blog'
    return HttpResponseRedirect(f'https://{domain}/v2/logout?returnTo={return_to}&client_id={client_id}')
"""

