digits = {
    "one" : '1',
    "two" : '2',
    "three" : '3',
    "four" : '4',
    "five" : '5',
    "six" : '6',
    "seven" : '7',
    "eight" : '8',
    "nine" : '9' 
}


def get_first_integer(line):
    for index, char in enumerate(line):
        forward = index + 3
        if char.isdigit():
            return char
        while forward < len(line) and forward <= index + 5: 
            if line[index : forward] in digits:
                return digits[line[index : forward]]
            forward += 1


def get_last_integer(line):
    line = line[::-1].replace(" ", "")
    for index, char in enumerate(line):
        forward = index + 3
        if char.isdigit():
            return char
        while forward < len(line) and forward <= index + 5: 
            if line[index : forward][::-1] in digits:
                return digits[line[index : forward][::-1]]
            forward += 1

if __name__ == "__main__":
    total_sum = 0
    with open('input') as file:
        for line in file:
            first_int = get_first_integer(line)
            last_int = get_last_integer(line)
            total_sum += int(first_int + last_int)
    print(f"Total sum is: {total_sum}\n")


