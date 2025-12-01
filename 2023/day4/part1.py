import re

if __name__ == "__main__":
    with open("input") as file:
        score = 0
        for line in file:
            print(f"New line {line}")
            seen_first = False  


            first_re = r"Card\s+\d+:\s+([^|]+)\|"
            second_re = r"\|(.*)"

            winning_numbers = set(re.search(first_re, line).group(1).strip().split())
            my_numbers = re.search(second_re, line).group(1).strip().split()


            current_score = 0
            for num in my_numbers:
                if num in winning_numbers and seen_first:
                    current_score *= 2
                elif num in winning_numbers and not seen_first:
                    current_score += 1
                    seen_first = True


            score += current_score

        print(f"final score is {score}")
                
            
            
            
