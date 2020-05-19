from django.urls import path, include

from . import views


urlpatterns = [
    path('', views.index, name = 'demo-home'),
    path('profile/', views.profile, name = 'demo-profile'),
    path('test/logout/', views.logout),
    path('blog/', views.index, name = 'blog-home')
]