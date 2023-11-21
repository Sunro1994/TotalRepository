import requests
from bs4 import BeautifulSoup
from selenium import webdriver;
import time

header = {'User-agent' : 'Mozilla/5.0'}
response = requests.get('https://www.goodchoice.kr/product/result?keyword=서울', header)
html = response.text
soup = BeautifulSoup(html, 'html.parser')

driver = webdriver.Chrome()
driver.get('https://www.goodchoice.kr/product/result?keyword=서울')
driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
selHtml = driver.page_source
selSoup = BeautifulSoup(selHtml, 'html.parser')



links = soup.select('.list_4 a')

results = []

idx = 0




for link in links :
    # 모텔인지 호텔인지
    # types = soup.select('.right_badges .badge .buildbadge')
    # type = types[idx].text
    # print(type)

    # # 링크에서 링크로 만듬soup
    # url = link.attrs['href']
    # response2 = requests.get(url)
    # details = BeautifulSoup(response2.text, 'html.parser')

    # # 숙소이름
    # titles = details.select('h2')
    # title = titles[0].text.replace('-', '')

    # #숙소 주소
    # addrs = details.select('.address')
    # addr = addrs[0].text

    # #숙소 평점
    # scores = details.select('.score_cnt span')
    # score = scores[0].text

    # #리스트 이미지 이름
    imgs = selSoup.select('.pic .lazy')
    img = imgs[idx]['src']
    print(img)

    idx = idx + 1
    # results.append(
    #     {
    #         'title'     : title,
    #         'address'   : addr,
    #         'score'     : score,
    #         'type'      : type 
    #     }
    # )

    time.sleep(3)