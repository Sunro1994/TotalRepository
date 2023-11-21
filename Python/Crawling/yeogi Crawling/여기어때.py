from requests import get
from bs4 import BeautifulSoup
from selenium import webdriver



def extract_yeogi_lodgin(keyword) :
    
    url = 'https://www.goodchoice.kr/product/result?keyword='+f'{keyword}';
    
    response = get(url);
    results = [];
    print(response.status_code)
    if(response.status_code == 200):
        soup = BeautifulSoup(response.text,'html.parser')
        step1 = soup.find_all('li',class_='list_4 adcno2')
        for step2 in step1:
            anchors = step2.find_all('a')
            link = anchors[0]['href']
            img = step2.find_all('img',class_='lazy')[0]['data-original']
            type = step2.find_all('span',class_='build_badge')[0].text
            grade = step2.find_all('span',class_='build_badge')[0].text
            rate = step2.find_all('p',class_="score")
            if rate and rate[0].find('span'):
                recommendation_text = rate[0].find('span').text.strip()
            find_p = step2.find_all('p')
            location ='위치없음'
            if find_p[2].text:
                location : find_p[2].text
            status = '알 수 없음'
            if find_p[3].text:
                status: find_p[3].text
            
            results.append(
                {
                    'link' : link,
                    'img' : img,
                    'type' : type,
                    'grade' : grade,
                    'rate & comment' : recommendation_text,
                    'location' : location,
                    'status' : status
                }
            )
            print('\n')
            
    for result in results:
        print(result)

           
                
        
extract_yeogi_lodgin('서울');