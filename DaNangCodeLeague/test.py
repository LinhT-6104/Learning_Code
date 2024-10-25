try:
    with open('KC.inp', 'r', encoding='utf-8') as fileInp:
        ten = fileInp.readline().rstrip('\n')
        tuoiHienTai = int(fileInp.readline().rstrip('\n'))
        # data = fileInp.readlines()
        # stringJoined = ' '.join(data).replace('\n', '')
    fileOut = open('KC.out', 'wb')
    stringToSave = '20 năm nữa, tuổi của {} sẽ là {}'.format(ten, tuoiHienTai + 20)
    fileOut.write(stringToSave.encode('utf8'))
    # fileOut.write(stringJoined.encode('utf8'))
except FileNotFoundError:
    print('Khong tim thay file')
except:
    print('Loi dinh dang file!')
    