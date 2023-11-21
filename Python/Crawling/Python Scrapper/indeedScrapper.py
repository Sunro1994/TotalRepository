from requests import get
from bs4 import BeautifulSoup
from selenium import webdriver

driver = webdriver.Chrome()
def get_page_count(keyword):
    driver.get(f'https://kr.indeed.com/jobs?q={keyword}&l=&from=searchOnHP&vjk=89395b6ac5014113')
    current_url = driver.current_url
    if f'https://kr.indeed.com/jobs?q={keyword}&l=&from=searchOnHP&vjk=89395b6ac5014113' in current_url:
        soup = BeautifulSoup(driver.page_source.encode('utf-8'),"html.parser")
        pagination = soup.find("nav",class_="css-jbuxu0 ecydgvn0")
        pages = pagination.find_all("div",recursive=False)
        if len(pages) == 0 :
            return 1
        count  = len(pages)
        if count >= 5:
            return 5
        else:
            return count
    else:
        print("잘못된 연결")



def extract_indeed_jobs(keyword) :
    pages = get_page_count(keyword)
    print("Found",pages,"ages")
    results = []
    for page in range(pages):
        current_page = page*10
        final_url = f'https://kr.indeed.com/jobs?q={keyword}&start={current_page}'
        driver.get(final_url)
        current_url = driver.current_url
        print("Requesting",final_url)
        if final_url in current_url:
        
            soup = BeautifulSoup(driver.page_source.encode('utf-8'),"html.parser")
            job_list = soup.find("ul", class_="css-zu9cdh eu4oa1w0")

            #recursive : 내부의 li까지 모두 찾지 않게 False로 설정
            jobs = job_list.find_all("li",recursive=False)

            for job in jobs:
                    zone = job.find("div",class_="mosaic-zone")
                    if zone == None:
                        h2 = job.find("h2",class_="jcs-JobTitle")
                        anchor = job.select_one("h2 a") #select는 list타입으로 가져온다.
                        #aria-label 은 리더기로 시각장애가 있는 사람들에게 읽어주기 위한 속성
                        title = anchor['aria-label']
                        link = anchor['href']
                        company = job.find("span",class_="companyName")
                        location = job.find("div", class_="companyLocation")
                        if location.string != None:
                            region = location.string.replace(","," ")
                        else:
                            region = location.string
                        
                        job_data = {
                            'link' : f"https://kr.indeed.com{link}",
                            'company' :company.string.replace(","," "),
                            'location' :region ,
                            'position':title.replace(","," ")
                        }
                        results.append(job_data)
    return results
                    


keyword = "python"
file = open(f"{keyword}.csv", "w", encoding="utf-8-sig") #w는 읽기 전용
file.write("Position,Company,Location,URL\n")

indeed = extract_indeed_jobs(keyword)

for job in indeed:
    file.write(f"{job['position']},{job['company']},{job['location']},{job['link']}\n")

file.close()



