# Five Views

Five Views is a **social platform** designed to share and discover valuable tools, websites, and resources. It allows users to post content using **Markdown**, interact through comments, votes, and shares, and receive **personalized notifications**. Built with a focus on **moderation** and **community engagement**, Five Views offers features like **post collaboration**, **category filtering**, and **analytics** for content creators.

---

## ✨ Features

### **Functional Features**
- **Markdown Support**: Write and format posts using Markdown.
- **Engagement Tools**: Comment on posts, reply to comments, and upvote/downvote content.
- **Content Management**: Save, download (as `.md` files), and share posts.
- **Personalization**: Follow profiles, receive notifications, and edit your profile (bio, avatar, etc.).
- **Analytics**: View detailed insights into post interactions (views, votes, shares).
- **Moderation**: Approve, reject, or provide feedback on posts to maintain community standards.

### **Non-Functional Features**
- **Security**: Secure authentication using UUIDs for user IDs.
- **Notifications**: Real-time updates and weekly digests delivered via email.
- **Efficient Discovery**: Category-based filtering for seamless content exploration.

---

## 🗄️ Database Schema

The project uses a **relational database** (Postgres) with the following tables:

| Table Name         | Description                                                                 |
|--------------------|-----------------------------------------------------------------------------|
| **readers**        | Stores user information with UUIDs as primary keys.                         |
| **posts**          | Contains all user-generated content.                                        |
| **categories**     | Defines content categories for filtering.                                   |
| **comments**       | Manages threaded discussions on posts.                                      |
| **votes**          | Tracks upvotes and downvotes on posts and comments.                         |
| **notifications**  | Sends alerts for relevant updates (e.g., new posts, comments, etc.).        |
| **post_reports**   | Gathers statistics on post engagement and performance.                      |
| **moderation**     | Handles post approval, rejection, and feedback.                             |
| **user_settings**  | Stores customizable preferences for users.                                  |
| **banned_posts**   | Maintains a log of banned posts with details (reason, moderator, etc.).     |

---

## 🛠️ Technologies

- **Backend**: Kotlin Spring (robust and scalable backend framework).
- **Frontend**: Angular (modern and responsive user interface).
- **Database**: Postgres (reliable relational database management system).
- **Authentication**: JWT with UUID-based user IDs (secure and efficient).

---

## 🤝 Contributing

We welcome contributions from the community! Here’s how you can get started:

1 - **Fork the repository** on GitHub.

2 - **Create a feature branch**:
   ```bash
   git checkout -b feature-name
   ```
3 - Commit your changes:
   ```bash
   git commit -m "Add new feature"
   ```
4 - Push your branch:
   ```bash
   git push origin feature-name
   ```
5 - Open a pull request on GitHub and describe your changes.

Please ensure your code follows the project's coding standards and includes relevant tests.

---

## 📬 Contact

For inquiries, support, or collaboration opportunities, feel free to reach out:

- Email: nickolasmaraujo@gmail.com

- GitHub: [nickolss](https://github.com/nickolss)

---

## 🙏 Acknowledgments
Thank you for your interest in Five Views! Your contributions and feedback help make this platform better for everyone.