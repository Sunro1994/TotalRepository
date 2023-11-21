import requests
from bs4 import BeautifulSoup
from selenium import webdriver
import time

driver = webdriver.Chrome()
response = driver.get('https://www.goodchoice.kr/product/result?keyword=부산')
# html = response.text
soup = BeautifulSoup(driver.page_source.encode('utf-8'), 'html.parser')

links = soup.select('.list_4 a')

results = []



idx = 0

for link in links :
    # 모텔인지 호텔인지
    types = soup.select('.right_badges .badge .build_badge')
   
    type = types[idx].text

    # 링크에서 링크로 만듬soup
    url = link.attrs['href']
    response2 = requests.get(url)
    details = BeautifulSoup(response2.text, 'html.parser')

    # 숙소이름
    titles = details.select('h2')
    title = titles[0].text.replace('-', '')

    #숙소 주소
    addrs = details.select('.address')
    addr = addrs[0].text

    #숙소 평점
    scores = details.select('.score_cnt span')
    score = scores[0].text

    # 리스트 이미지 이름
    imgs = soup.select('.pic  img')
    img = imgs[idx]['src']
    print(img)
    idx = idx + 1
    time.sleep(10)

    results.append(
        {
            'title'     : title,
            'address'   : addr,
            'score'     : score,
            'type'      : type 
        }
    )