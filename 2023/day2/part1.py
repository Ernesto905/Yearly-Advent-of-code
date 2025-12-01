import re

def is_valid_game(line):
    # Patterns for each color
    red_pattern = r'(\d+)\s*red'
    green_pattern = r'(\d+)\s*green'
    blue_pattern = r'(\d+)\s*blue'

    # Find all matches
    reds = re.findall(red_pattern, line)
    greens = re.findall(green_pattern, line)
    blues = re.findall(blue_pattern, line)

    for val in reds:
        if int(val) > 12:
            return 0 
    for val in greens:
        if int(val) > 13:
            return 0 
    for val in blues:
        if int(val) > 14:
            return 0 
    return 1 
            
if __name__ == "__main__":

    total = 0

    with open("input") as input:
        for line in input:
            if is_valid_game(line):
                game_number = re.search(r'\d+', line).group()                
                total += int(game_number)                 
    print(total)



