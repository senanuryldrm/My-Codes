a = input("enter numbers separated by spaces: ")

numbers = a.split(" ")
total = 0
for i in numbers:
    total = total + int(i)

print("average of the numbers : ", total/len(numbers))
