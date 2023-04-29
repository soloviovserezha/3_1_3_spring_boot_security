# 3_1_3_spring_boot_security

присваивание роли происходит в UserServiceImpl, методе public boolean saveUser(User user){}

в классе User пришлось выставить настройку ```fetch = FetchType.EAGER```, а то идея ругалась
на запуск ApplicationRunner с ```fetch = FetchType.LAZY```

Когда добавлял юзеров ручками через регистрацию, код с LAZY не фейлился   