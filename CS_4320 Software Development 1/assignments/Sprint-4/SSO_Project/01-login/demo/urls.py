from django.urls import path, include

from . import views


urlpatterns = [
    path('', views.index, name='index'),
    path('', include('social_django.urls')),
    path('demo/profile/', views.profile),
    path('logout/', views.logout),
]