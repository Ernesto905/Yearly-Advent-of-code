if __name__ == "__main__":

    with open("input") as file:
        input = list()

        for line in file:
            input.append(line.rstrip())


        gear_ratio = list()
        NUM = '0123456789'

        for col, line in enumerate(input):
            for row, cell in enumerate(line):
                nums = list()          
                if cell == '*':
                    if col > 0:
                        current_num = ""
                        if input[col-1][row] in NUM:
                            current_num += input[col-1][row]
                        left = 1
                        while row - left >= 0 and input[col-1][row - left] in NUM:
                            current_num = input[col-1][row - left] + current_num
                            left += 1
                        if input[col-1][row] not in NUM and current_num:
                            nums.append(int(current_num))
                            current_num = ""
                        right = 1
                        while row + right < len(line) and input[col-1][row + right] in NUM:
                            current_num += input[col-1][row + right]
                            right += 1
                        if current_num:
                            nums.append(int(current_num))
                            current_num = ""
                    if col < len(input):
                        current_num = ""
                        if input[col+1][row] in NUM:
                            current_num += input[col+1][row]
                        left = 1
                        while row - left >= 0 and input[col+1][row - left] in NUM:
                            current_num = input[col+1][row - left] + current_num
                            left += 1
                        if input[col+1][row] not in NUM and current_num:
                            nums.append(int(current_num))
                            current_num = ""
                        right = 1
                        while row + right < len(line) and input[col+1][row + right] in NUM:
                            current_num += input[col+1][row + right]
                            right += 1
                        if current_num:
                            nums.append(int(current_num))
                            current_num = ""

                    if row > 0:
                        current_num = ""
                        left = 1
                        while row - left >= 0 and input[col][row - left] in NUM:
                            current_num = input[col][row - left] + current_num
                            left += 1
                        
                        if current_num:
                            nums.append(int(current_num))
                            current_num = ""

                    if row < len(line):
                        current_num = ""
                        right = 1
                        while row + right < len(line) and input[col][row + right] in NUM:
                            current_num += input[col][row + right]
                            right += 1
                        
                        if current_num:
                            nums.append(int(current_num))
                            current_num = ""
                    if len(nums) == 2:
                        gear_ratio.append(nums[0] * nums[1])
    print(sum(gear_ratio))
