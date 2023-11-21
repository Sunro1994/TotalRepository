from bs4 import BeautifulSoup
from requests import get

base_url = "https://weworkremotely.com/categories/remote-back-end-programming-jobs#job-listings"

response = get(f"{base_url}")
if response.status_code != 200:
    print("Can't request website")
else:
    soup = BeautifulSoup(response.text, 'html.parser')
    jobs =  soup.find_all('section', class_="jobs")

    
    for jobs_section in jobs:
            job_posts = jobs_section.find_all('li')
            
            for post in job_posts:
                   anchors = post.find_all('a')
                   print(anchors[0])
               