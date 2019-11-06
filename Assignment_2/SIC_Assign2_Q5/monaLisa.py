from PIL import Image 
im = Image.open("mona_lisa.jpg")
pixels = im.load() 

studentNumber = list(bin(3718718)[2:])
pixelsMap = {}

for x in range (0, 22):
    pixelsMap[x] = list(pixels[((x + 1)*10), ((x + 1)*50)])

    print("Original red value (Decimal): ", end ="")
    print(pixelsMap[x][0])

    binaryPixel = bin(pixelsMap[x][0])[2:]
    print("Original red value (Binary): ", end ="")
    print(binaryPixel)

    print("Student number bit used: ", end ="")
    print(studentNumber[x])

    binaryList = list(binaryPixel)
    binaryList[len(binaryList) - 1] = studentNumber[x]
    print("New red value (Binary): ", end ="")
    newBinary = "".join(binaryList)
    print(newBinary)

    pixelsMap[x][0] = int(newBinary, 2)
    print("Original red values (Decimal): ", end ="")
    print(pixelsMap[x][0])
    print("")

im.save("newpath.png")