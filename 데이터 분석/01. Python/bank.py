class Account :
 
    def  __init__ (self, owner, accNo, balance):
        self.__owner = owner
        self.__accNo = accNo
        self.__balance = balance
    
    # 은닉되어있는 계좌번호를 볼 수 있게끔 getter 이용
    def getAccNo(self):
        return self.__accNo

    def getBalance(self):
        return self.__balance # 그냥 balance하면 안됨!
    

    def showAccountInfo(self):
        return f'소유주: {self.__owner}, 계좌번호: {self.__accNo}, 잔고: {self.__balance}'
    
    def deposit(self, amount):
        self.__balance += amount
        
    def withdraw(self, amount) :
        if self.__balance >= amount:
            self.__balance -=amount
        else :
            raise InvalidTransactionException('출금 잔고가 부족합니다')
    
    def transfer(self, target, amount):
        if self.__balance >= amount:
            self.__balance -= amount # 또는 self.withdraw(amount)
            target.deposit(amount)
        else :
            raise InvalidTransactionException('이체 잔고가 부족합니다')

     


# BO (Business Object)
# 뱅킹 시스템의 업무 로직을 관리하는 클래스
# 1) 새로 생성된 Account 객체를 저장
# 2) 등록된 Account 객체를 계좌번호로 조회
# 3) 등록된 모든 Account 객체를 반환

class BankManager:
    
    def __init__ (self):
        self.__account_list = []
        
    # 1) 새로 생성된 Account 객체를 저장
    def addAccount(self, a):
        self.__account_list.append(a)

    # 2) 등록된 Account 객체를 계좌번호로 조회
    def searchAccount(self, accNo):
        result = None
        for a in self.__account_list: 
            if a.getAccNo() == accNo: ## get~~
                result = a
                break
        return result
    
    # 3) 등록된 모든 Account 객체를 반환
    def getAllAccountList(self):
        return self.__account_list
    
    
class InvalidTransactionException(Exception):
    # msg의 역할 : 사용자 정의 예외가 발생할 때 상황에 따른 특정 예외 메세지
    def __init__(self, msg):
        self.msg  = msg
    
    # str 함수 재정의 : 주소값 출력이 아닌, 정의된 내용이 출력될 수 있게끔 오버라이딩
    def __str__ (self):
        return self.msg
        
