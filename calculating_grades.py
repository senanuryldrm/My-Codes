sid_list = []
midterm_list = []
hw_list = []
final_list = []
avg_list = []
letter_list = []
lecture_list = []
total_avg = 0



while True:
    sid = int(input("Student ID:"))
    midterm = int(input("Midterm:"))
    hw = int(input("Homework:"))
    final = int(input("Final:"))
    avg = midterm * 0.2 + hw * 0.2 + final * 0.6
    total_avg = total_avg + avg
    
    sid_list.append(sid)
    midterm_list.append(midterm)
    hw_list.append(hw)
    final_list.append(final)
    avg_list.append(avg)
    
    if final <40:
        print("Failed")
        letter_list.append("F")
        lecture_list.append("Failed")

    else:
        if avg >= 90:
            print("A\n","Passed")
            letter_list.append("A")
            lecture_list.append("Passed")
        elif avg >= 80:
            print("B\n","Passed")
            letter_list.append("B")
            lecture_list.append("Passed")
        elif avg >= 70:
            print("C\n","Passed")
            letter_list.append("C")
            lecture_list.append("Passed")
        elif avg >= 60:
            print("D\n","Passed")
            letter_list.append("D")
            lecture_list.append("Passed")
        else:
            print("F")
            print("Failed")
            letter_list.append("F")
            lecture_list.append("Failed")
    
    
    
    
    
    q = input("Do you want to add a new student? (Y) or (N)")
    if q == "N":
        False
        break
    
print("Avarage:", total_avg / len(sid_list))
print("ID        M      H       F        A              L          S")
print("---------------------------------------------------------------")

for j in range(len(sid_list)):
    print(sid_list[j],"\t", midterm_list[j],"\t", hw_list[j],"\t", final_list[j],"\t", avg_list[j],"\t\t", letter_list[j],"\t", lecture_list[j], end ='  \n')
print()