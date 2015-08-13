#version 400 core

in vec3 position;

out vec3 colour;

uniform mat4 translationMatrix;
uniform vec3 uniformColour;

void main(void) {
	
	gl_Position = translationMatrix * vec4(position, 1.0);
	colour = uniformColour;
	
}