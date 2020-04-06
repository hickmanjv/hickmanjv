from django.db import models
from django.utils import timezone
from django.contrib.auth.models import User
from django.urls import reverse

class Post(models.Model):
	"""
	Table in the database for Posts
	Migrations allow us to make changes to the database after it has be created
	and has data already loaded in, without messing up our data
	"""
	title = models.CharField(max_length = 100)
	content = models.TextField()
	date_posted = models.DateTimeField(default = timezone.now) #auto_now = True  works for updated tag
	author = models.ForeignKey(User, on_delete = models.CASCADE)  # on_delete needed in case user gets deleted, using CASCADE so posts get deleted

	def __str__(self):
		return self.title

	# redirect vs reverse
	# redirect will just send you to a particular route
	# reverse will return the full url as a string

	def get_absolute_url(self):
		return reverse('post-detail', kwargs={'pk': self.pk})