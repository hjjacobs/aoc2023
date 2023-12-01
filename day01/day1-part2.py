def last_digit_position(text):
    last_position = -1  # Initialize with a default value that indicates no digit found yet

    for index, char in enumerate(text):
        if char.isdigit():
            last_position = index  # Update the last position whenever a digit is found

    return last_position

def first_digit_position(text):
    for index, char in enumerate(text):
        if char.isdigit():
            return index  # Return the position of the first digit found
    return -1  # Return -1 if no digits are found in the string

path = 'day01/input.txt'

with open(path) as f:
    lines = f.read().splitlines()

digits = ['one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']

total = 0

for line in lines:
    # find position of first digit
    first = first_digit_position(line)

    # find position of first written digit
    first_a = len(line)

    for digit in digits:
        if ((a:= line.find(digit)) > -1) and (a < first_a):
            first_a = a
            first_num_a = digits.index(digit)+1

    # find position of last digit

    last = last_digit_position(line)

    # find position of last written digit
    last_a = -1

    for digit in digits:
        if ((a := line.rfind(digit)) > -1) and (a > last_a):
            last_a = a
            last_num_a = digits.index(digit)+1

    # determine which digit is first
    if first_a < first:
        first = first_num_a
    else:
        first = line[first]

    # determine which digit is last
    if (last_a > last):
        last = last_num_a
    else:
        last = line[last]

    total = total + int(str(first)+str(last))

print(f"total: {total}")
