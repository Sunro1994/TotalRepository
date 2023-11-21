

player = {
    
    'name': 'nico',
    'age' : 12,
    'alive' : True,
    'favoriteFood' : ["apple","orange"]
}

#get을 통해 특정 key의 value가져오기
print(player.get('age'))

print(player)
#pop은 해당 값을 보여주고 key를 반환
print(player.pop('age'))
print(player)

#새로운 값을 추가
player['xp'] = 1500
print(player)

player['favoriteFood'].append("banana")
print(player)
