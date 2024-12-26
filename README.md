# Tableware Management System

This project is a console-based system to manage tableware (e.g., cups, spoons, plates) and administrators. It supports
commands to login, manage users, and manipulate tableware data. Below is a list of available commands and their
descriptions.

## Commands

### General Command Format

Commands follow this structure:

```
<command> -<parameter> <value> ...
```

Example:

```
/login -r admin -e admin@example.com -p password
```

### User Management

#### 1. Login

Log in as a user with specified credentials.

```
/login -r <role> -e <email> -p <password>
```

- `-r`: User role (e.g., admin)
- `-e`: Email
- `-p`: Password

#### 2. Delete User

Delete a user by their ID.

```
/deluser -i <id>
```

- `-i`: User ID

#### 3. Show All Users

View all users or a specific user by ID.

```
/showalluser [-i <id>]
```

- `-i`: (Optional) User ID

#### 4. Add New Admin

Add a new admin user.

```
/newadmin -n <name> -e <email> -p <password> -r <role>
```

- `-n`: Admin name
- `-e`: Email
- `-p`: Password
- `-r`: Role

### Tableware Management

#### 1. Add New Tableware

Add a new item to the tableware inventory. Supported types: `cup`, `spoon`, `plate`.

```
/newtableware -t <type> -n <name> -m <material> -p <price> -c <color> [specific parameters]
```

- `-t`: Tableware type (`cup`, `spoon`, `plate`)
- `-n`: Name
- `-m`: Material
- `-p`: Price
- `-c`: Color

**Specific Parameters by Type:**

- **Cup**:
    - `-v`: Volume
    - `-s`: Size

  Example:
  ```
  /newtableware -t cup -n "Coffee Cup" -m ceramic -p 500 -c white -v 300 -s 10
  ```

- **Spoon**:
    - `-l`: Length
    - `-t`: Type

  Example:
  ```
  /newtableware -t spoon -n "Tea Spoon" -m steel -p 200 -c silver -l 15 -t small
  ```

- **Plate**:
    - `-d`: Diameter

  Example:
  ```
  /newtableware -t plate -n "Dinner Plate" -m porcelain -p 800 -c white -d 25
  ```

#### 2. Show All Tableware

Display all tableware items or a specific item by ID.

```
/showalltableware -t <type> [-i <id>]
```

- `-t`: Tableware type (`cup`, `spoon`, `plate`)
- `-i`: (Optional) Item ID

Example:

```
/showalltableware -t spoon
```

#### 3. Delete Tableware

Delete a tableware item by ID and type.

```
/deltableware -t <type> -i <id>
```

- `-t`: Tableware type (`cup`, `spoon`, `plate`)
- `-i`: Item ID

Example:

```
/deltableware -t cup -i 123
```

### System Commands

#### Exit

Terminate the application.

```
/exit
```

### Error Handling

If a required parameter is missing, the system will prompt you to enter all required parameters.

### Example Workflow

1. Login as an admin:
   ```
   /login -r admin -e admin@example.com -p password
   ```
2. Add a new cup:
   ```
   /newtableware -t cup -n "Coffee Cup" -m ceramic -p 500 -c white -v 300 -s 10
   ```
3. Show all cups:
   ```
   /showalltableware -t cup
   ```
4. Delete a cup by ID:
   ```
   /deltableware -t cup -i 101
   ```
5. Exit the system:
   ```
   /exit
   ```

---

Developed for managing tableware and user administration efficiently via the console.

