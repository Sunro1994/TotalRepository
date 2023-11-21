import urllib

params = urllib.parse.urlencode({'category':'역사','page':251})
url = "http://unico2013.dthome.co.kr/crawling/exercise.php?%s" %params with urllib.reqeust.urlopen(url) as f:
    pring(f.read().decode('utf-8'))