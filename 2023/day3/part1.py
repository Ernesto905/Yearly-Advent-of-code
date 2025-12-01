if __name__ == "__main__":
    with open("input") as file:
        input = list()
        for line in file:
            input.append(line.rstrip())


        part_nums = list()
        NUM = '0123456789'

        for row, line in enumerate(input):
            for row, cell in enumerate(line):            
                if cell not in '0123456789.':
                    if row > 0:
                        current_num = ""
                        if input[row-1][row] in NUM:
                            current_num += input[row-1][row]
                        left = 1
                        while row - left >= 0 and input[row-1][row - left] in NUM:
                            current_num = input[row-1][row - left] + current_num
                            left += 1
                        if input[row-1][row] not in NUM and current_num:
                            part_nums.append(int(current_num))
                            current_num = ""
                        right = 1
                        while row + right < len(line) and input[row-1][row + right] in NUM:
                            current_num += input[row-1][row + right]
                            right += 1
                        if current_num:
                            part_nums.append(int(current_num))
                            current_num = ""
                    if row < len(input):
                        current_num = ""
                        if input[row+1][row] in NUM:
                            current_num += input[row+1][row]
                        left = 1
                        while row - left >= 0 and input[row+1][row - left] in NUM:
                            current_num = input[row+1][row - left] + current_num
                            left += 1
                        if input[row+1][row] not in NUM and current_num:
                            part_nums.append(int(current_num))
                            current_num = ""
                        right = 1
                        while row + right < len(line) and input[row+1][row + right] in NUM:
                            current_num += input[row+1][row + right]
                            right += 1
                        if current_num:
                            part_nums.append(int(current_num))
                            current_num = ""

                    if row > 0:
                        current_num = ""
                        left = 1
                        while row - left >= 0 and input[row][row - left] in NUM:
                            current_num = input[row][row - left] + current_num
                            left += 1
                        
                        if current_num:
                            part_nums.append(int(current_num))
                            current_num = ""

                    if row < len(line):
                        current_num = ""
                        right = 1
                        while row + right < len(line) and input[row][row + right] in NUM:
                            current_num += input[row][row + right]
                            right += 1
                        
                        if current_num:
                            part_nums.append(int(current_num))
                            current_num = ""
        
    print(sum(part_nums))
