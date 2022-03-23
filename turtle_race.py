import random
import time


def PrintTrack(a,b,c,end):
    line=""    
    for i in range(1, end+1):
        if len(str(i)) == 1:
            line += "0" + str(i) + " "
        else:
            line += str(i) + " "
    print(line)
    for i in range(1,end+1):
        print("---",end="")
    print()
    WriteTurtles("A ",a,end)
    WriteTurtles("B ",b,end)
    WriteTurtles("C ",c,end)
    print()
    

    
def WriteTurtles(turtlenames,turtlesteps,end):
    for i in range(1,end+1):
        if i==turtlesteps:
            print(turtlenames,end=" ")
        else:
            print("-- ",end="")
    print()



def moveTurtle(x):
    choise=random.randint(1,11)
    if x>2 and choise==1:
        return x-2
    elif choise<=3 and choise>1 and x>1:
        return x-1
    elif choise<=5 and choise>3:
        return x
    elif choise<=9 and choise>5:
        if (x+1)>end:
            return end
        return x+1
    elif choise==10:
        if (x+2)>end:
            return end
        return x+2
    else:
        return x
    return x


a=1
b=1
c=1
end=int(input("Please enter the length of race:"))
r=0

finish=True

while finish:
    time.sleep(1)
    if r==0:
        PrintTrack(a,b,c,end)
        r=+1
    a = moveTurtle(a)
    b = moveTurtle(b)
    c = moveTurtle(c)
    PrintTrack(a,b,c,end)
    if(a==end and b == end) or (a==end and c==end) or (b==end and c==end):
        print("Tie")
        break
    else:
        if a==end:
            print("A won")
            break
        if b==end:
            print("B won")
            break
        if c==end:
            print("C won")
            break
