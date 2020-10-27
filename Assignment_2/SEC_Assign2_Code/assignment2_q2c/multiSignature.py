def checkPrime():
    switch = True
    while switch == True:
        try:
            prime = int(input("Please enter a prime number: "))
        except ValueError:
            print("Error - Input was not a whole number")
            continue
        else:
            if prime > 1:
                for i in range(2, prime):
                    if (prime % i) == 0:
                        print(prime, "is not a prime number")
                        print(i, "times", prime//i, "is", prime)
                        break
                    else:
                        print(prime,"is a prime number")
                        switch = False
                        break
            else:
                print(prime1, "is not a prime number")
    return prime
def egcd(a, b):
    if a == 0:
        return (b, 0, 1)
    else:
        g, y, x = egcd(b % a, a)
        return (g, x - (b // a) * y, y)
def modinv(a, m):
    g, x, y = egcd(a, m)
    if g != 1:
        raise Exception('modular inverse does not exist')
    else:
        return x % m
def powerMod(a, b, p):
    d = pow(a, b) % p 
    return d

print("\nThis is a simulation of RSA Multi-Signature for 3 users\n\n")

while True:
    try:
        message = int(input("Enter your message (Whole Number): "))
    except ValueError:
        print("Error - Input was not a whole number")
        continue
    else:
        break

print("---PRIME 1/2---")
prime1 = checkPrime()
print("---PRIME 2/2---")
prime2 = checkPrime()

nValue = prime1 * prime2
print("----------\n\nn = first prime X second prime.\nn =", prime1, "X", prime2, "=", nValue)
phi = (prime1 - 1) * (prime2 - 1)
print("\nphi(n) = (first prime - 1) X (second prime - 1).\nphi(n) = (", prime1, "- 1 ) X (", prime2, "- 1 )")
print("phi(n) =", prime1 - 1, "X", prime2 - 1, "=", phi)

print("\n----------\n---PRIVATE KEY 1/3---")
privKey1 = checkPrime()
print("---PRIVATE KEY 2/3---")
privKey2 = checkPrime()
print("---PRIVATE KEY 3/3---")
privKey3 = checkPrime()
privKeyProd = privKey1 * privKey2 * privKey3
print("----------\n\nPrivate Key 1 =", privKey1, "\nPrivate Key 2 =", privKey2, "\nPrivate Key 3 =", privKey3)

print("\n----------\n\nPublic Key = ((Private Key 1) X (Private Key 2) X (Private Key 3))^-1 mod(phi(n))")
print("Public Key = (", privKey1, "X", privKey2, "X", privKey3, ")^-1 mod(", phi, ")")
print("Public Key = (", privKeyProd, ")^-1 mod(", phi, ")")
pubKey = modinv(privKeyProd, phi)
print("Public Key =", pubKey)

print("\n----------\n\nUser 1 signing the message with Private Key 1")
print("Signed Message = Message^(Private Key 1) mod(n)")
print("Signed Message =", message, "^(", privKey1, ") mod(", nValue, ")")
signed1 = powerMod(message, privKey1, nValue)
print("Signed Message =", signed1)

print("\nUser 2 co-signing the message with Private Key 2")
print("Signed Message = Message Signed by Private Key 1^(Private Key 2) mod(n)")
print("Signed Message =", signed1, "^(", privKey2, ") mod(", nValue, ")")
signed2 = powerMod(signed1, privKey2, nValue)
print("Signed Message =", signed2)

print("\nUser 3 co-signing the message with Private Key 3")
print("Signed Message = Message Signed by Private Key 2^(Private Key 3) mod(n)")
print("Signed Message =", signed2, "^(", privKey3, ") mod(", nValue, ")")
signed3 = powerMod(signed2, privKey3, nValue)
print("Signed Message =", signed3)
print("\nSignature = (", signed3, ",", message, ")")

print("\n----------\n\nMulti-Signature Verification")
print("De-Crypted Message = Signed Message^(Public Key) mod(n)")
print("De-Crypted Message =", signed3, "^(", pubKey, ") mod (", nValue, ")\n")

print("----------\n---Use the Public Key to Verify the Signature---\n*HINT:", pubKey)
userKey = int(input("Enter Public Key: "))
dMessage = powerMod(signed3, userKey, nValue)
print("De-Crypted Message =", dMessage, "\n----------\n")

if message == dMessage:
    print("Message = De-Crypted Message!\n\nMessage:", message, "\nSignature:", signed3, "\n\nMulti-Signature VERIFIED!\nMessage ACCEPTED!\n")
else:
    print("ERROR: Failed to verify Multi-Signature.\nMessage REJECTED.\n")

input("Enter any key to close...")