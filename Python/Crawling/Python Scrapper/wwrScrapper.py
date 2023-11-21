from bs4 import BeautifulSoup
from requests import get

base_url = "https://weworkremotely.com/categories/remote-back-end-programming-jobs#job-listings"

response = get(f"{base_url}")
if response.status_code != 200:
    print("Can't request website")
else:
    results = [];
    soup = BeautifulSoup(response.text, 'html.parser')
    jobs =  soup.find_all('section', class_="jobs")
    for job_section in jobs:
        job_posts = job_section.find_all('li')
        job_posts.pop(-1);
        job_posts.pop(0);
        for post in job_posts:
            anchors =post.find_all('a')
            anchor = anchors[1]
            link = anchor['href']
            company, kind, region = anchor.find_all('span',class_="company")
            title = anchor.find('span',class_='title')
            print(company.string,region.string,title.string)
            job_data = {
                'company' : company.string,
                'region' : region.string,
                'position' : title.string,
                'link' : f"https://weworkremotely.com{link}"
            }
            results.append(job_data)
            for result in results:
                print(result)
            print(len(results))