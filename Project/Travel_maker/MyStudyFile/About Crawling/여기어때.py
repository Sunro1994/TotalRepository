from requests import get
from bs4 import BeautifulSoup
from selenium import webdriver

webdriver.Chrome();


def extract_yeogi_lodgin(keyword) :
    url = 'https://www.goodchoice.kr/product/result?keyword=' + f'{keyword}'
    response = get(url)
    
    results = []

    if response.status_code == 200:
        soup = BeautifulSoup(response.text, 'html.parser')
        step1 = soup.find_all('li', class_='list_4 adcno2')
        
        for step2 in step1:
            print(step2)
            anchors = step2.find_all('a')
            link = anchors[0]['href']
            img = step2.find_all('img', class_='lazy')[0]['data-original']
            type = step2.find_all('span', class_='build_badge')[0].text
            grade = step2.find_all('span', class_='build_badge')[0].text
            rate = step2.find_all('p', class_="score")
            recommendation_text = ""
            if rate and rate[0].find('span'):
                recommendation_text = rate[0].find('span').text.strip()
            
            find_p = step2.find_all('p')
            simpleLocation = find_p[3].text if len(find_p) > 2 else '자료없음'
            status = find_p[4].text if len(find_p) >2 else '자료없음'
            results.append(
                {
                    'link': link,
                    'img': img,
                    'type': type,
                    'grade': grade,
                    'rate & comment': recommendation_text,
                    'simpleLocation': simpleLocation,
                    'status': status
                }
            )

    return results

extract_yeogi_lodgin('서울')
   
                
keyword = ["서울","대전","대구","부산","광주","강원도"]

for key in keyword:
    file = open(f"{key}.csv","w",encoding="utf-8-sig")
    file.write("link,img,type,grade,rate&comment,simpleLocation,status\n")
    result = extract_yeogi_lodgin(key);

    for res in result:
        file.write(f"{res['link']},{res['img']},{res['type']},{res['grade']},{res['rate & comment']},{res['simpleLocation']},{res['status']}\n")
        
file.close()