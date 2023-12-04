# NoteNinja
A note-taking app for computer science students, with python code snippets and 
AI-assisted helper.

## Table of Contents:
- [Software Overview](#software-specifications)
- [Entities in the Domain](#entities-of-the-domain)
- [Future Enhancements](#future-enhancements)

## Software Specifications

NoteNinja's is a fully functional note-taking app for computer-science students
(or any developer for that fact). NoteNinja's has the following core features, including
some bonus features for coders too.

- **Runnable AI & Code Snippets**: Users can write simple ```Python-code``` and run it within their
note-taking environment. An extremely helpful note-taking feature for computer-science 
students in class. The AI-Snippet feature allows the user to prompt chat-GPT to aid with understanding
, saving GPTs responses in the note.


- **Note-searching**: User's can create as many notes as they need. To aid users with navigating
of their notes an effective search-bar is provided on the home page (allowing for navigation
by note title).


- **Functional Note-editor**: Along with the bonus code/AI-snippets NoteNinjas includes a fully
functional text editor style note-taking application to help with standard note-taking needs.
The note editor allows users to save, name, and delete notes as required.


## Entities of the Domain:

NoteNinja's is structured around major entities of the domain. The following list out the 
entities of NoteNinja's and each entities key pieces of data (Instance Variables).


### AI Snippet

- ```String snippetQuestion```: User's AI prompt/question.
- ```String snippetResponse```: Open AI AI response to prompt.


### Code Snippet

- ```String code```: User's ```Python``` code input.
- ```String output```: Glott api response (Glott takes Python code and gives Python code output).


### Note

- ```String name```: Title of users note.
-  ```String text```: Text within the users note.
-  ``` int ID```: ID associated with note, utilized for code search.


# Future Enhancements
Upcoming updates and enhancements:
`

- **User-login Authentication System**: Allow for secure registration and log in 
to allow for note-protection.

- **Tagging/Sorting Notes**: Add tagging and sorting of notes for ease of note navigation.

- **Cloud Back-up System**: Using user-login/information implement cloud back-up to prevent 
note/data loss prevention.




