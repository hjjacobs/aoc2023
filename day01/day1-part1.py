path = 'day01/input-hj.txt'

with open(path) as f:
    lines = f.read().splitlines()

total = 0

for line in lines:

    first = [x.isdigit() for x in line].index(True)
    
    rev_line = line[::-1]
    last = [x.isdigit() for x in rev_line].index(True)

    number = line[first] + rev_line[last]

    total = total + int(number)

    print(f"{line} ==> {line[first]} | {rev_line[last]} = {number}")

print(f"total: {total}")
