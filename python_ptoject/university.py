class Student:

    def __init__(self, id, name, surname):
        self.setID(id)
        self.name = name
        self.surname = surname

    def getID(self):
        return self.__id

    def setID(self,id):
        if len(id)==6:
            self.__id = id

    def __str__(self):
        return self.name + ' ' + self.surname + ' ' + self.__id


students = {}
ada = []
f = open("student.txt", 'r')
for line in f:
    linearr = line.split()
    id = linearr[0]
    name = linearr[1]
    surname = linearr[2]
    students[id] = Student(id, name, surname)
    ada.append(Student(id, name, surname))
f.close()

def stud(x):
    student_id = input("Give a student id:")
    for a in x:
        if a.getID()==student_id:
            return a.name + " " + a.surname
    return "Student not found"

answer_list = []
z = open("answers.txt", 'r')
for answers in z:
    answers = answers.strip()
    answer_list.append(answers)
z.close()

key_list = []
x = open("key.txt", 'r')
for keys in x:
    keys = keys.strip()
    key_list.append(keys)
x.close()

unifile_list = []
h = open("university.txt")
for unis in h:
    unis = unis.strip()
    unis = unis.split(",")
    unifile_list.append(unis)
h.close()

uninoname = []
z = open("university.txt", 'r')
unipoint_list = []
for uniscore in z:
    uniscore.strip()
    uniscore = uniscore.split(',')
    school = uniscore[2], uniscore[1]
    unipoint_list.append(school)
    uninoname.append(uniscore[1])
z.close()


def unispoint():
    unipoint_list.sort(reverse=True)
    for i in unipoint_list:
        print(i[1], ",", float(i[0]))


def results():
    c = open("result.txt", 'w')
    for ans in answer_list:
        answersplit = ans.split(' ')
        if answersplit[1] == 'B':
            qtrue = 0
            qfalse = 0
            qblank = 0
            for i in range(len(answersplit[2])):
                if key_list[1][i] == answersplit[2][i]:
                    qtrue = qtrue + 1

                elif answersplit[2][i] == '-':
                    qblank = qblank + 1

                else:
                    qfalse = qfalse + 1
            for std in students:
                xd = students.get(answersplit[0])

            c.write(xd.getID() + ", " + xd.name + ", " + xd.surname + ", " + str(answersplit[1]) + ", " + str(
                qtrue) + ", " + str(qfalse) + ", " + str(qblank) + ", " + str(qtrue - (qfalse / 4)) + ", " + str(
                (qtrue - (qfalse / 4)) * 15) + ", " + uninoname[int(answersplit[3]) - 1] + ", " + uninoname[
                        int(answersplit[4]) - 1] + ", " + uninoname[int(answersplit[5]) - 1] + ", " + uninoname[
                        int(answersplit[6]) - 1] + ", " + uninoname[int(answersplit[7]) - 1] + "\n")

        elif answersplit[1] == 'A':
            qtrue = 0
            qfalse = 0
            qblank = 0
            for i in range(len(answersplit[2])):
                if key_list[0][i] == answersplit[2][i]:
                    qtrue = qtrue + 1

                elif answersplit[2][i] == '-':
                    qblank = qblank + 1

                else:
                    qfalse = qfalse + 1
            for std in students:
                xd = students.get(answersplit[0])

            c.write(xd.getID() + ", " + xd.name + ", " + xd.surname + ", " + str(answersplit[1]) + ", " + str(
                qtrue) + ", " + str(qfalse) + ", " + str(qblank) + ", " + str(qtrue - (qfalse / 4)) + ", " + str(
                (qtrue - (qfalse / 4)) * 15) + ", " + uninoname[int(answersplit[3]) - 1] + ", " + uninoname[
                        int(answersplit[4]) - 1] + ", " + uninoname[int(answersplit[5]) - 1] + ", " + uninoname[
                        int(answersplit[6]) - 1] + ", " + uninoname[int(answersplit[7]) - 1] + "\n")
    c.close()

def studentscore():
    sy = open('result.txt', 'r')
    studentscore_list = []
    for stscore in sy:
        stscore = stscore.strip()
        stscore = stscore.split(',')
        a = float(stscore[8]), stscore[1], stscore[2], stscore[0]
        studentscore_list.append(a)
        studentscore_list.sort(reverse=True)
    sy.close()
    for i in studentscore_list:
        print(i[3], i[1], i[2], i[0])


gulugulu = []
gulugulu1 = []
def uniplace():
    results()
    w = open("result.txt","r")
    result_list=[]
    for i in w:
        i=i.strip()
        i=i.split(", ")
        result = [float(i[8]), i[0],i[1],i[2],i[9],i[10],i[11],i[12],i[13]]
        result_list.append(result)
    result_list.sort(reverse=True)
    w.close()
    for k in result_list:
        for t in answer_list:
            t = t.split(" ")
            if int(k[1])==int(t[0]):
                if k[0]>=float(unifile_list[int(t[3])-1][2]) and int(unifile_list[int(t[3])-1][3])>0:
                    gulugulu.append(k[1] + ", " + k[2] + ", " + k[3] + ", " + str(k[0]) + ", " + k[4])
                    (unifile_list[int(t[3])-1][3])=int(unifile_list[int(t[3])-1][3])-1
                elif k[0]>=float(unifile_list[int(t[4])-1][2]) and int(unifile_list[int(t[4])-1][3])>0:
                    (unifile_list[int(t[4]) - 1][3])=int(unifile_list[int(t[4])-1][3])-1
                    gulugulu.append(k[1] + ", " + k[2] + ", " + k[3] + ", " + str(k[0]) + ", " + k[5])
                elif k[0]>=float(unifile_list[int(t[5])-1][2]) and int(unifile_list[int(t[5])-1][3])>0:
                    (unifile_list[int(t[5]) - 1][3])=int(unifile_list[int(t[5])-1][3])-1
                    gulugulu.append(k[1] + ", " + k[2] + ", " + k[3] + ", " + str(k[0]) + ", " + k[6])
                elif k[0]>=float(unifile_list[int(t[6])-1][2]) and int(unifile_list[int(t[6])-1][3])>0:
                    (unifile_list[int(t[6]) - 1][3])=int(unifile_list[int(t[6])-1][3])-1
                    gulugulu.append(k[1] + ", " + k[2] + ", " + k[3] + ", " + str(k[0]) + ", " + k[7])
                elif k[0]>=float(unifile_list[int(t[7])-1][2]) and int(unifile_list[int(t[7])-1][3])>0:
                    (unifile_list[int(t[7]) - 1][3])=int(unifile_list[int(t[7])-1][3])-1
                    gulugulu.append(k[1] + ", " + k[2] + ", " + k[3] + ", " + str(k[0]) + ", " + k[8])
                else:
                    gulugulu1.append(k[1] + ", " + k[2] + ", " + k[3] + ", " + str(k[0]))
    w.close()

broad = []
meadows = []
eagle = []
cypress = []
martin = []
great = []
sunset1 = []
sunvalley = []
laguna = []
southfork = []
sunset2 = []
def uniplace2():
    uniplace()
    for g in gulugulu:
        g = g.strip()
        g = g.split(", ")
        if g[4]==unifile_list[0][1]:
            broad.append(g[0] + " " + g[1] + " " + g[2] + " " + g[3])
        elif g[4]==unifile_list[1][1]:
            meadows.append(g[0] + " " + g[1] + " " + g[2] + " " + g[3])
        elif g[4]==unifile_list[2][1]:
            eagle.append(g[0] + " " + g[1] + " " + g[2] + " " + g[3])
        elif g[4]==unifile_list[3][1]:
            cypress.append(g[0] + " " + g[1] + " " + g[2] + " " + g[3])
        elif g[4]==unifile_list[4][1]:
            martin.append(g[0] + " " + g[1] + " " + g[2] + " " + g[3])
        elif g[4]==unifile_list[5][1]:
            great.append(g[0] + " " + g[1] + " " + g[2] + " " + g[3])
        elif g[4]==unifile_list[6][1]:
            sunset1.append(g[0] + " " + g[1] + " " + g[2] + " " + g[3])
        elif g[4]==unifile_list[7][1]:
            sunvalley.append(g[0] + " " + g[1] + " " + g[2] + " " + g[3])
        elif g[4]==unifile_list[8][1]:
            laguna.append(g[0] + " " + g[1] + " " + g[2] + " " + g[3])
        elif g[4]==unifile_list[9][1]:
            southfork.append(g[0] + " " + g[1] + " " + g[2] + " " + g[3])
        elif g[4]==unifile_list[10][1]:
            sunset2.append(g[0] + " " + g[1] + " " + g[2] + " " + g[3])


uniplace2()
def uniplace3():
    print(unifile_list[0][1])
    print("------------------------------------------------")
    if len(broad)==0:
        print("No student")
    else:
        k=1
        for p in broad:
            print(str(k)+")",p)
            k+=1
    print(" ")
    print(unifile_list[1][1])
    print("------------------------------------------------")
    if len(meadows) == 0:
        print("No student")
    else:
        k=1
        for p in meadows:
            print(str(k)+")",p)
            k += 1
    print(" ")
    print(unifile_list[2][1])
    print("------------------------------------------------")
    if len(eagle) == 0:
        print("No student")
    else:
        k=1
        for p in eagle:
            print(str(k)+")",p)
            k += 1
    print(" ")
    print(unifile_list[3][1])
    print("------------------------------------------------")
    if len(cypress) == 0:
        print("No student")
    else:
        k=1
        for p in cypress:
            print(str(k)+")",p)
            k += 1
    print(" ")
    print(unifile_list[4][1])
    print("------------------------------------------------")
    if len(martin) == 0:
        print("No student")
    else:
        k=1
        for p in martin:
            print(str(k)+")",p)
            k += 1
    print(" ")
    print(unifile_list[5][1])
    print("------------------------------------------------")
    if len(great) == 0:
        print("No student")
    else:
        k=1
        for p in great:
            print(str(k)+")",p)
            k += 1
    print(" ")
    print(unifile_list[6][1])
    print("------------------------------------------------")
    if len(sunset1) == 0:
        print("No student")
    else:
        k=1
        for p in sunset1:
            print(str(k)+")",p)
            k += 1
    print(" ")
    print(unifile_list[7][1])
    print("------------------------------------------------")
    if len(sunvalley) == 0:
        print("No student")
    else:
        k=1
        for p in sunvalley:
            print(str(k)+")",p)
            k += 1
    print(" ")
    print(unifile_list[8][1])
    print("------------------------------------------------")
    if len(laguna) == 0:
        print("No student")
    else:
        k=1
        for p in laguna:
            print(str(k)+")",p)
            k += 1
    print(" ")
    print(unifile_list[9][1])
    print("------------------------------------------------")
    if len(southfork) == 0:
        print("No student")
    else:
        k=1
        for p in southfork:
            print(str(k)+")",p)
            k += 1
    print(" ")
    print(unifile_list[10][1])
    print("------------------------------------------------")
    if len(sunset2) == 0:
        print("No student")
    else:
        k=1
        for p in sunset2:
            print(str(k)+")",p)
            k += 1


def departments():
    departments = []
    departments1 = []
    for dep in unipoint_list:
        a = dep[1].find('University')
        b = dep[1][a + 11:]
        departments.append(b)
    for department in departments:
        if department not in departments1:
            departments1.append(department)
    for department in departments1:
        print(department)


def menu():
    print("[1] Search for a student with a given id and display his/her name and surname")
    print("[2] List the universities/departments sorted by their base points")
    print("[3] Create a file named 'results.txt' for each student")
    print("[4] List the student information sorted by their score")
    print("[5] List the students placed in every university/department")
    print("[6] List the students who were not be able to placed anywhere")
    print("[7] List all the departments")

menu()
while True:
    option = int(input("Please enter your option:"))
    if option == 1:
        b=stud(ada)
        print(b)
    elif option == 2:
        unispoint()
    elif option == 3:
        results()
        print("Saved result.txt")
    elif option == 4:
        studentscore()
    elif option == 5:
        uniplace3()
    elif option == 6:
        print("Mezuna Kalanlar")
        for i in gulugulu1:
            print(i)
        print("Total: ", len(gulugulu1))
    elif option == 7:
        departments()

    q = input("Do you want to continue? (Y) or (N)")
    if q == "Y":
        menu()
    elif q == "N":
        break
    else:
        print("You did something wrong")
        menu()