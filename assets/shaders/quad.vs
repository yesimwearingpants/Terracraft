#version 400 core

in vec3 position;
in vec2 texCoords;

out vec2 passTexCoords;

uniform mat4 translationMatrix;

void main(void) {
	
	gl_Position = translationMatrix * vec4(position, 1.0);
	passTexCoords = texCoords;
	
}