# AES Encryption using Cipher Block Chaining mode

from Crypto.Cipher import AES
import os

BLOCK_SIZE = 16

def encrypt(msg, key):
    # \x00 is hexadecimal notation
    # 16 bytes Initialization vector
    iv = BLOCK_SIZE * '\x00'

    # Crypto library does the Cipher Block chaining
    # and encrypts the message
    return AES.new(key, AES.MODE_CBC, iv).encrypt(msg)


def decrypt(cipher, key):
    # Hard-coding the iv because it's too long to type
    iv = BLOCK_SIZE * '\x00'
    decryptor = AES.new(key, AES.MODE_CBC, IV=iv)
    plain = decryptor.decrypt(cipher)
    return plain

def main():
    message = input("Enter a message to be encrypted: ")
    key = os.urandom(16)

    # Key is given for demonstration purposes
    print("Key that is used: {}".format(key))

    encrypted = encrypt(message, key)
    print(encrypted)
    decrypted = decrypt(encrypted, key)
    print(decrypted)


if __name__ == "__main__":
    main()

print()