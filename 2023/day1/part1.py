def get_first_integer(line):
    for char in line:
        if char.isdigit():
            return char

def get_last_integer(line):
    for char in reversed(line):
        if char.isdigit():
            return char

if __name__ == "__main__":
    total_sum = 0
    with open('input') as file:
        for line in file:
            total_sum += int(get_first_integer(line) + get_last_integer(line))
    print(f"Total sum is: {total_sum}\n")


