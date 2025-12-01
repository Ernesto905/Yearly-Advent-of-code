import re

def get_max_colors(line):
    # Patterns for each color
    red_pattern = r'(\d+)\s*red'
    green_pattern = r'(\d+)\s*green'
    blue_pattern = r'(\d+)\s*blue'

    # Find all matches
    reds = re.findall(red_pattern, line)
    greens = re.findall(green_pattern, line)
    blues = re.findall(blue_pattern, line)

    return [max(map(int, reds)), max(map(int, greens)), max(map(int, blues))]
            
if __name__ == "__main__":

    total = 0

    with open("input") as input:
        for line in input:
            red, green, blue = get_max_colors(line)
            total += red * green * blue
    print(total)



